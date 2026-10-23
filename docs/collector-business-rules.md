# Collector business rules

Apply these rules to new collectors and changes to existing collectors.

## Collection and resume

- Do not synchronize accounts with `syncEnabled = false`: ti’bu ignores their collected data, so skipping them saves time and resources.
- Collect operations from oldest to newest, across pages and years.
- Limit each run to **5 minutes**, including authentication and downloads. Start no further requests after the deadline; an in-flight request may finish.
- Reaching the deadline is a normal stop: return completed operations and save progress for the next run.
- Store resume checkpoints in persistent collector settings. Do not rely solely on the last synchronization date: a run may be partial.
- Commit progress after each fully processed operation. Retry operations interrupted by the deadline.
- Use stable references to prevent duplicates when resuming. A date alone is insufficient: multiple operations can share the same date.
- Do not rely solely on page numbers for resume: pagination can change between runs.
- Verify that the site applied the requested filters before committing progress.

## Shopping accounts

- Keep an order whenever its **date**, **reference**, and **amount** are known.
- Look up missing required fields in the order details before skipping it. Never invent an amount; a missing amount does not mean zero.
- Build the label from item titles. If unavailable, generate `Order <merchant> <reference>`.
- Items, payment details, images, and invoices are optional. Missing data or extraction errors must not discard a valid order.
- An item extraction error must not prevent collecting other items.
- An order extraction error must not stop other orders. Log its reference and the cause; preserve completed results.
- Skip fully cancelled, uncharged orders. A cancelled item or shipment alone must not discard the entire order.

## Authentication

- A successful HTTP response does not prove authentication succeeded: detect sign-in forms and identity challenges.
- Report unsupported CAPTCHAs or identity challenges with an explicit `ConnectionFailure`. Do not proceed as if authentication succeeded.
