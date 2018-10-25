## 1. nested integer sum I and II

1. some special input

the input could be null, could be empty


2. basic idea,

use a bfs to iterate each nested integer, if it's an integer, then add the result, otherwise put it into the queue, and in the end of this level, add the depth.

from this example, we can append the original number to the queue again, and what,
