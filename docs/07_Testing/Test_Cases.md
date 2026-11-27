# Test Cases

No automated test suite has been added yet. Suggested manual checks:

| Case | Action | Expected result |
| --- | --- | --- |
| Start and exit | Run the app and choose 0 | App exits cleanly |
| Invalid menu input | Enter a non-number or out-of-range option | Prompt repeats with a validation message |
| Place standard order | Enter valid order details and choose no urgency | Order is created and nearest available rider is assigned |
| Place urgent order | Place an urgent order and view orders | Urgent orders appear before standard orders |
| Advance delivery | Advance an assigned order twice | Status reaches `DELIVERED`; rider becomes available at destination |
| Route endpoints | Place an order at a different grid coordinate | Printed route travels from rider via restaurant to customer |
| Rider unavailable | Place enough concurrent orders to occupy riders | Further order remains unassigned until a rider is available |

Automated verification can be added under `src/test/java` with a test framework in `pom.xml`.
