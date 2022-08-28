### Build the central bank accounts search engine

Linked List concept can be used to deal with many practical problems. This question helps
you to understand how to design data structure to build a search engine.
To build a central search engine for banks, you have to design a data structure to organize
customer account transaction details so that customer can access their record efficiently
(like ATM onelink). Consider a bank account number below and its associated labels that
may help you in building the data structure design. Suppose we are considering account
within Pakistan so ignore country code and digits.

```
**PK36SCBL0000001123456702**
Country code PK
Check digits 36
Bank code SCBL
Bank account number 0000001123456702
```

Suppose you need to program an application that has a pre-defined number of categories
(bank code), but the exact items (account numbers) in each category is unknown. Further
each item (account number) refer to list of transaction

<img width="462" alt="image" src="https://user-images.githubusercontent.com/94866222/187089463-2db71d18-cec3-4b1d-8017-1b2a474cfd13.png">

You have to implement the following methods to build the search engine and write the bigOh
of each method:
- `insert(String AcNo)`
- `search(String AcNo)` → return list of transactions corresponding to the accountNo.
- `delete(String AcNo)`
- `toString()` → display all accounts with list of transactions 
