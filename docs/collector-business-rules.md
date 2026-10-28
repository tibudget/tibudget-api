# Collector business rules

## Collection and resume

- Do not synchronize accounts with `syncEnabled = false`: Tibu ignores their collected data, so skipping them saves time and resources.
- Collect operations from oldest to newest, across pages and years.
- Commit progress after each fully processed transaction.
- Use stable references to prevent duplicates when resuming. A date alone is insufficient: multiple operations can share the same date.
- Do not rely solely on page numbers for resume: pagination can change between runs.

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
