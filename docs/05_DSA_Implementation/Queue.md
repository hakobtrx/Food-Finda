# Queue

There is no dedicated FIFO queue in the current implementation. New orders are added to a list and remain in `PLACED` status until a rider can be assigned. A queue could represent pending work explicitly in a later version.
