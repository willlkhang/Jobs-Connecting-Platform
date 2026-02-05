categories = {
    "Information Technology": "laptop won't turn on, building web, building application, building software, wifi broken, server crash, screen, printer offline, install software, recover files, virus removal, coding help, password reset",
    "Cooking": "private chef needed, baking cakes, meal prep for week, catering for party, vegan menu, teaching how to cook, food delivery for event, baking lessons, dietary restrictions",
    "Handiworks": "assemble furniture, fix door handle, hang shelves, painting wall, repair fence, fix roof leak, drywall patch, carpentry, broken window, lock replacement",
    "Plumbing": "sink leaking, toilet clogged, low water pressure, pipe burst, install faucet, shower not draining, water heater broken, blocked drain, leak detection",
    "Electricity": "outlet not working, light switch broken, breaker keeps tripping, install ceiling fan, rewire house, flickering lights, install EV charger, fuse blown",
    "Cleaning": "deep clean apartment, carpet cleaning, window washing, move-out cleaning, office cleaning, power wash driveway, tidy up messy room, laundry service",
    "Education": "math tutor, piano lessons, learn spanish, sat prep, help with history homework, physics tutor, coding lessons, essay writing help, english teacher",
    "Well Being": "yoga instructor, meditation coach, life coaching, stress management, mindfulness session, spiritual guidance, relaxation techniques, personal mentor",
    "Health": "nursing care for elderly, feel sick, need medicine, physiotherapy, wound dressing, post-surgery care, check blood pressure, medical assistance, home nurse, injection service",
    "Accounting": "file taxes, bookkeeping for small business, audit assistance, financial planning, payroll help, quickbooks support, tax return, expense tracking"
}

generation_prompt = """You are a synthetic data generator. Generate 60 unique, diverse, and realistic user job requests for the category: "{category}".

                    Context keywords to inspire you: {keywords}

                    Rules:
                    1. The requests must sound like REAL customers (some angry, some polite, some urgent, some short, some detailed).
                    2. Do NOT number the list.
                    3. Output ONLY the requests, one per line.
                    4. Do not start lines with "I need" every time. Vary the phrasing.
                    5. Do not use the category name in the request (e.g., don't say "I need plumbing", say "my pipe burst").
                    """