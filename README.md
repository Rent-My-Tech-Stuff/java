# Rent My Tech Stuff Java Backend 

## Introduction

This is a basic database scheme with users and rentals. This Java Spring REST API application will provide endpoints for clients to read various data sets contained in the application's data. This application will also form the basis of a user authentication application developed elsewhere in the course

### Database layout

The table layout is similar to the initial version with the following exceptions:

* All tables have audit fields
* User is the driving table.
* Rentals have a Many-To-One relationship with User. Each User has many rentals. Each rental has only one User.
* Roles and useremai fields can be ignored. 

Using the provided seed data, expand each endpoint below to see the output it generates.

### User Authentication
This backend is using the OAUTH2 protocol for authentication.

---

<details>
<summary>http://localhost:2019/users/users</summary>

```JSON
[
  {
    "user_id": 4,
    "username": "admin",
    "email": "admin@lambdaschool.local",
    "firstname": "Admin",
    "lastname": "Admin",
    "address": "221B Baker Street",
    "streetAddress": "221B Baker Street",
    "city": "London",
    "state": "London",
    "zipcode": "88888",
    "rentals": [],
    "roles": [
        {
            "role": {
                "roleid": 1,
                "name": "OWNER"
            }
        },
        {
            "role": {
                "roleid": 2,
                "name": "RENTER"
            }
        }
      ]
    },
    {
        "user_id": 13,
        "username": "anisha.schumm",
        "email": "bernardo.kris@yahoo.com",
        "firstname": "Tommie",
        "lastname": "Farrell",
        "address": "59794 Karl Forest",
        "streetAddress": "58259 Kerry Shoals",
        "city": "Lake Lurlene",
        "state": "Oregon",
        "zipcode": "77827",
        "rentals": [
            {
                "rental_id": 14,
                "name": "Enormous Linen Keyboard",
                "description": "Et sint eum harum laborum perspiciatis porro. Repudiandae recusandae distinctio aspernatur dolores assumenda sed quo. Voluptatem repellat a. Nihil quas animi ducimus.",
                "image": "https://source.unsplash.com//200x200?sig=incrementingIdentifier",
                "price": 76.73
            }
        ],
        "roles": [
            {
                "role": {
                    "roleid": 2,
                    "name": "RENTER"
                }
            }
        ]
      }
]
```

</details>

<details>
<summary>http://localhost:2019/users/user/7</summary>

```JSON
{
    "user_id": 7,
    "username": "cinnamon",
    "email": "cinnamon@lambdaschool.local",
    "roles": [
        {
            "role": {
                "roleid": 2,
                "name": "RENTER"
            }
        }
    ]
}
```

</details>

<details>
<summary>http://localhost:2019/users/user/name/cinnamon</summary>

```JSON
{
    "user_id": 7,
    "username": "cinnamon",
    "email": "cinnamon@lambdaschool.local",
    "roles": [
        {
            "role": {
                "roleid": 2,
                "name": "RENTER"
            }
        }
    ]
}
```

</details>

<details>
<summary>http://localhost:2019/users/user/name/like/da</summary>

```JSON
[]
```

</details>

<details>
<summary>POST http://localhost:2019/users/user</summary>

DATA

```JSON
{
    "username": "Mojo",
    "email": "mojo@lambdaschool.local",
    "password" : "Coffee123",
    "roles": [
        {
            "role": {
                "roleid": 1
            }
        },
        {
            "role": {
                "roleid": 2
            }
        }
    ]
}
```

OUTPUT

```TEXT
No Body Data

Location Header: http://localhost:2019/users/user/17
Status 201 Created
```

</details>

<details>
<summary>http://localhost:2019/users/user/name/mojo</summary>

</details>

<details>
<summary>PUT http://localhost:2019/users/user/14</summary>

DATA

```JSON
{
    "username": "stumps",
    "email": "stumps@lambdaschool.local",
    "password" : "EarlGray123",
    "roles": [
        {  
            "role": {
                "roleid": 3
            }
        },
        {  
            "role": {
                "roleid": 1
            }
        }
    ]
}
```

OUTPUT

```TEXT
No Body Data

Status OK
```

</details>

<details>
<summary>http://localhost:2019/users/user/name/stumps</summary>

```JSON
{
    "user_id": 16,
    "username": "stumps",
    "email": "stumps@lambdaschool.local",
    "roles": [
        {
            "role": {
                "roleid": 1,
                "name": "OWNER"
            }
        }
    ]
}
```

</details>

<details>
<summary>PATCH http://localhost:2019/users/user/7</summary>

DATA

```JSON
{
    "username": "cinabun",
    "email": "cinabun@lambdaschool.home"
}
```

OUTPUT

```TEXT
No Body Data

Status OK
```

</details>

<details>
<summary>http://localhost:2019/users/user/name/cinabun</summary>

</details>

```JSON
{
    "user_id": 7,
    "username": "cinabun",
    "email": "cinabun@lambdaschool.home",
    "roles": [
        {
            "role": {
                "roleid": 2,
                "name": "RENTER"
            }
        }
    ]
}
```

<details>

<summary>DELETE http://localhost:2019/users/user/14</summary>

```TEXT
No Body Data

Status OK
```

</details>


<details>
<summary>http://localhost:2019/rentals/rentals</summary>

```JSON
[
  {
        "rental_id": 14,
        "name": "Enormous Linen Keyboard",
        "description": "Et sint eum harum laborum perspiciatis porro. Repudiandae recusandae distinctio aspernatur dolores assumenda sed quo. Voluptatem repellat a. Nihil quas animi ducimus.",
        "image": "https://source.unsplash.com//200x200?sig=incrementingIdentifier",
        "price": 76.73,
        "user": {
            "user_id": 13,
            "username": "anisha.schumm",
            "email": "bernardo.kris@yahoo.com",
            "firstname": "Tommie",
            "lastname": "Farrell",
            "address": "59794 Karl Forest",
            "streetAddress": "58259 Kerry Shoals",
            "city": "Lake Lurlene",
            "state": "Oregon",
            "zipcode": "77827",
            "roles": [
                {
                    "role": {
                        "roleid": 2,
                        "name": "RENTER"
                    }
                }
            ]
        }
    },
    {
        "rental_id": 17,
        "name": "Ergonomic Cotton Car",
        "description": "Quia ex quas at ea quo nihil consequatur. Alias explicabo consequatur dolorum. Quas rerum consequuntur architecto repellendus voluptatem.",
        "image": "https://source.unsplash.com//200x200?sig=incrementingIdentifier",
        "price": 76.09,
        "user": {
            "user_id": 16,
            "username": "marianela.leffler",
            "email": "brendon.corkery@gmail.com",
            "firstname": "Miesha",
            "lastname": "Zieme",
            "address": "2541 Boyle Springs",
            "streetAddress": "52241 Jast Bridge",
            "city": "New Tamekia",
            "state": "Tennessee",
            "zipcode": "64968",
            "roles": [
                {
                    "role": {
                        "roleid": 2,
                        "name": "RENTER"
                    }
                }
            ]
        }
    }
]
```

</details>
