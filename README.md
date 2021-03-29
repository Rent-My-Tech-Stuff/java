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

---

<details>
<summary>http://localhost:2019/users/users</summary>

```JSON
[
  {
    "userid": 4,
    "username": "admin",
    "primaryemail": "admin@lambdaschool.local",
    "usertype": "owner",
    "firstname": "Admin",
    "lastname": "Admin",
    "address": "221B Baker Street",
    "streetaddress": "221B Baker Street",
    "city": "London",
    "state": "London",
    "zipcode": 88888,
    "rentals": [],
    "useremails": [
        {
            "useremailid": 5,
            "useremail": "admin@email.local"
        },
        {
            "useremailid": 6,
            "useremail": "admin@mymail.local"
        }
    ],
    "roles": [
        {
            "role": {
                "roleid": 1,
                "name": "ADMIN"
            }
        },
        {
            "role": {
                "roleid": 2,
                "name": "USER"
            }
        },
        {
            "role": {
                "roleid": 3,
                "name": "DATA"
            }
        }
      ]
    },
    {
        "userid": 13,
        "username": "anisha.schumm",
        "primaryemail": "bernardo.kris@yahoo.com",
        "usertype": "owner",
        "firstname": "Tommie",
        "lastname": "Farrell",
        "address": "59794 Karl Forest",
        "streetaddress": "58259 Kerry Shoals",
        "city": "Lake Lurlene",
        "state": "Oregon",
        "zipcode": 77827,
        "rentals": [
            {
                "rentalid": 14,
                "name": "Enormous Linen Keyboard",
                "description": "Et sint eum harum laborum perspiciatis porro. Repudiandae recusandae distinctio aspernatur dolores assumenda sed quo. Voluptatem repellat a. Nihil quas animi ducimus.",
                "image": "https://source.unsplash.com//200x200?sig=incrementingIdentifier",
                "price": 76.73
            }
        ],
        "useremails": [
            {
                "useremailid": 15,
                "useremail": "ggud88@gmail.com"
            }
        ],
        "roles": [
            {
                "role": {
                    "roleid": 2,
                    "name": "USER"
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
    "userid": 7,
    "username": "cinnamon",
    "primaryemail": "cinnamon@lambdaschool.local",
    "useremails": [
        {
            "useremailid": 9,
            "useremail": "favbun@hops.local"
        },
        {
            "useremailid": 10,
            "useremail": "bunny@email.local"
        }
    ],
    "roles": [
        {
            "role": {
                "roleid": 2,
                "name": "USER"
            }
        },
        {
            "role": {
                "roleid": 3,
                "name": "DATA"
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
    "userid": 7,
    "username": "cinnamon",
    "primaryemail": "cinnamon@lambdaschool.local",
    "useremails": [
        {
            "useremailid": 9,
            "useremail": "favbun@hops.local"
        },
        {
            "useremailid": 10,
            "useremail": "bunny@email.local"
        }
    ],
    "roles": [
        {
            "role": {
                "roleid": 2,
                "name": "USER"
            }
        },
        {
            "role": {
                "roleid": 3,
                "name": "DATA"
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
    "primaryemail": "mojo@lambdaschool.local",
    "password" : "Coffee123",
    "useremails": [
        {
            "useremail": "mojo@mymail.local"
        },
        {
            "useremail": "mojo@email.local"
        }
        ],
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
    "primaryemail": "stumps@lambdaschool.local",
    "password" : "EarlGray123",
    "useremails": [
        {
            "useremail": "stumps@mymail.local"
        },
        {
            "useremail": "stumps@email.local"
        }
        ],
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
    "userid": 16,
    "username": "stumps",
    "primaryemail": "stumps@lambdaschool.local",
    "useremails": [
        {
            "useremailid": 19,
            "useremail": "stumps@mymail.local"
        },
        {
            "useremailid": 20,
            "useremail": "stumps@email.local"
        }
    ],
    "roles": [
        {
            "role": {
                "roleid": 1,
                "name": "ADMIN"
            }
        },
        {
            "role": {
                "roleid": 3,
                "name": "DATA"
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
    "primaryemail": "cinabun@lambdaschool.home",
    "useremails": [
    {
            "useremail": "cinnamon@mymail.home"
    },
    {
            "useremail": "hops@mymail.home"
    },
    {
            "useremail": "bunny@email.home"
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
<summary>http://localhost:2019/users/user/name/cinabun</summary>

</details>

```JSON
{
    "userid": 7,
    "username": "cinabun",
    "primaryemail": "cinabun@lambdaschool.home",
    "useremails": [
        {
            "useremailid": 21,
            "useremail": "cinnamon@mymail.home"
        },
        {
            "useremailid": 22,
            "useremail": "hops@mymail.home"
        },
        {
            "useremailid": 23,
            "useremail": "bunny@email.home"
        }
    ],
    "roles": [
        {
            "role": {
                "roleid": 2,
                "name": "USER"
            }
        },
        {
            "role": {
                "roleid": 3,
                "name": "DATA"
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
        "rentalid": 14,
        "name": "Enormous Linen Keyboard",
        "description": "Et sint eum harum laborum perspiciatis porro. Repudiandae recusandae distinctio aspernatur dolores assumenda sed quo. Voluptatem repellat a. Nihil quas animi ducimus.",
        "image": "https://source.unsplash.com//200x200?sig=incrementingIdentifier",
        "price": 76.73,
        "user": {
            "userid": 13,
            "username": "anisha.schumm",
            "primaryemail": "bernardo.kris@yahoo.com",
            "usertype": "owner",
            "firstname": "Tommie",
            "lastname": "Farrell",
            "address": "59794 Karl Forest",
            "streetaddress": "58259 Kerry Shoals",
            "city": "Lake Lurlene",
            "state": "Oregon",
            "zipcode": 77827,
            "useremails": [
                {
                    "useremailid": 15,
                    "useremail": "ggud88@gmail.com"
                }
            ],
            "roles": [
                {
                    "role": {
                        "roleid": 2,
                        "name": "USER"
                    }
                }
            ]
        }
    },
    {
        "rentalid": 17,
        "name": "Ergonomic Cotton Car",
        "description": "Quia ex quas at ea quo nihil consequatur. Alias explicabo consequatur dolorum. Quas rerum consequuntur architecto repellendus voluptatem.",
        "image": "https://source.unsplash.com//200x200?sig=incrementingIdentifier",
        "price": 76.09,
        "user": {
            "userid": 16,
            "username": "marianela.leffler",
            "primaryemail": "brendon.corkery@gmail.com",
            "usertype": "owner",
            "firstname": "Miesha",
            "lastname": "Zieme",
            "address": "2541 Boyle Springs",
            "streetaddress": "52241 Jast Bridge",
            "city": "New Tamekia",
            "state": "Tennessee",
            "zipcode": 64968,
            "useremails": [
                {
                    "useremailid": 20,
                    "useremail": "yjeq51@gmail.com"
                }
            ],
            "roles": [
                {
                    "role": {
                        "roleid": 2,
                        "name": "USER"
                    }
                }
            ]
        }
    }
]
```

</details>
