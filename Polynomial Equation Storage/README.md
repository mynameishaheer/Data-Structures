### Store equation in singly linked list

Design and implement the data structure to store polynomial expression.
For example, below **P(x)** and **Q(x)** are polynomial expression with variable **x**.

**P(x) = 6x^2-3x + 4** and **Q(x) = 4x^2 +5x + 1** ,

One possible data structure is as follows while you can suggest you own representation of
data structure. Each node will store coefficient and power. To store whole polynomial
expression multiple nodes can be created and link together as a list.

<img width="127" alt="image" src="https://user-images.githubusercontent.com/94866222/187089708-4802459b-55b3-4265-a5ad-05330abab426.png">

Here suppose **P(x)** can be represented as follows

<img width="389" alt="image" src="https://user-images.githubusercontent.com/94866222/187089714-7ed1161b-af44-4f47-8f7d-474ca64a89f9.png">

Now implement a method that adds two polynomial expressions.
For example, there are two polynomials
<br />
**P(x) = 6x^2 -3x + 4** and **Q(x) = 4x^2 +5x + 1**,
where addition of **P(x)+Q(x) = 10 x^2 +2x + 5**.
