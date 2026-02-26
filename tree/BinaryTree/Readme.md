🌳 Binary Tree Concepts Used
1️⃣ Har node ka maximum 2 children

Binary Tree me:

1 left child

1 right child

ya dono nahi

------
2️⃣ Har child ka sirf ek parent hona chahiye

Binary Tree ka rule:

Ek node ke multiple parents nahi ho sakte.

------
3️⃣ Sirf ek hi root hona chahiye

Binary Tree me:

Root ka koi parent nahi hota.

Baaki sab nodes ka exactly 1 parent hota hai.

Isliye:

Jo node map me nahi hai → wahi root candidate.

Agar 1 se zyada mil gaye → invalid.

Agar koi root hi nahi mila → invalid.

-----
4️⃣ Tree me cycle nahi hona chahiye

Tree ek acyclic graph hota hai.

Agar cycle hoga:

BFS/DFS me node dubara visit hoga.

------
5️⃣ Tree connected hona chahiye

Binary Tree ka matlab:

Har node root se reachable hona chahiye.

Isliye:

BFS(root) ke baad count == n hona chahiye.

Agar count < n → koi node disconnected hai.

------
6️⃣ Nodes count property

Valid Binary Tree me:

Edges = Nodes - 1

Yaha indirectly check ho raha hai:

Har node ka at most 1 parent

Ek root

Fully connected

Ye sab milke ensure karta hai edges = n - 1.
