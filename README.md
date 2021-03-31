# Rent My Tech Stuff Java Backend 

## Introduction

This is a basic database scheme with users and rentals. This Java Spring REST API application will provide endpoints for clients to read various data sets contained in the application's data. This application will also form the basis of a user authentication application developed elsewhere in the course

### Database layout

The table layout is similar to the initial version with the following exceptions:

* All tables have audit fields
* User is the driving table.
* Rentals have a Many-To-One relationship with User. Each User has many rentals. Each rental has only one User.
* Roles and useremail fields can be ignored. 

Using the provided seed data, expand each endpoint below to see the output it generates.

### User Authentication
This backend is using the OAUTH2 protocol for authentication.

### Production deployment
https://web39mytechstuff.herokuapp.com

---

<h6>Create a new user</h6>
<details>
<summary>POST /api/register</summary>

AXIOS OBJECT SHAPE EXAMPLE

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

EXAMPLE RESPONSE

```TEXT
No Body 

Location Header: /api/user/17
Status 201 Created
```

</details>

<h6>Login a new user</h6>
<details>
<summary>/api/login</summary>

AXIOS EXAMPLE REQUEST

```js
axios
  .post(
    process.env.NODE_ENV === 'production'
      ? 'https://<production name tbd>.herokuapp.com/api/login'
      : 'http://localhost:2019/api/login',
    `grant_type=password&username=${credentials.username}&password=${credentials.password}`,
    {
      headers: {
        // btoa is converting our client id/client secret into base64
        Authorization: `Basic ${btoa('lambda-client:lambda-secret')}`,
        'Content-Type': 'application/x-www-form-urlencoded',
      },
    }
  )
  .then(res => {
    localStorage.setItem('token', res.data.access_token);
  });
```

Return a token (store in localStorage)

</details>

<h6>Get a list of all rentals</h6>
<details>
<summary>GET /api/rentals</summary>

EXAMPLE RESPONSE

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
        "rentalid": 17,
        "name": "Ergonomic Cotton Car",
        "description": "Quia ex quas at ea quo nihil consequatur. Alias explicabo consequatur dolorum. Quas rerum consequuntur architecto repellendus voluptatem.",
        "image": "https://source.unsplash.com//200x200?sig=incrementingIdentifier",
        "price": 76.09,
        "user": {
            "userid": 16,
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

<h6>Get rental by id</h6>
<details>
<summary>GET /api/rental/:id</summary>

EXAMPLE RESPONSE
```JSON
{
    "rentalid": 13,
    "name": "Lightweight Rubber Coat",
    "description": "Cumque facilis dicta deleniti. Voluptates culpa accusantium quae minima rerum quia libero. Explicabo eaque omnis nihil voluptatum esse quia optio. Laborum velit iure. Corrupti voluptatum autem est.",
    "image": "https://source.unsplash.com//200x200?sig=incrementingIdentifier",
    "price_per_day": 57.78,
    "user": {
        "userid": 12,
        "username": "deangelo.mccullough",
        "email": "leland.schroeder@gmail.com",
        "firstname": "Andrew",
        "lastname": "Morar",
        "address": "833 Beahan Center",
        "streetAddress": "8057 Huels Parks",
        "city": "South Elden",
        "state": "Indiana",
        "zipcode": "79541-8594",
        "useremails": [
            {
                "useremailid": 19,
                "useremail": "qjte78@gmail.com"
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
}
```

</details>

<h6>Get rental by name or location search</h6>
<details>
<summary>GET /api/rentals/:rental/:location</summary>

```js
{
  // pending
}
```

</details>

<h6>Get a listing of all owners</h6>
<details>
<summary>GET /roles/role/1</summary>

EXAMPLE REPONSE

```JSON
{
    "roleid": 1,
    "name": "OWNER",
    "users": [
        {
            "user": {
                "userid": 3,
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
                "useremails": [
                    {
                        "useremailid": 4,
                        "useremail": "admin@email.local"
                    },
                    {
                        "useremailid": 5,
                        "useremail": "admin@mymail.local"
                    }
                ]
            }
        }
    ]
}

```
</details>

<h6>Get a listing of rentals by owner id</h6>
<details>
<summary>GET /api/rentals/3</summary>

EXAMPLE REPONSE

```JSON
[
    {
        "rentalid": 13,
        "name": "Intelligent Silk Knife",
        "description": "Modi inventore optio minima iste voluptatem. Voluptatem soluta quibusdam est unde deserunt exercitationem sit. Officia autem porro cumque fugit harum.",
        "image": "https://source.unsplash.com//200x200?sig=incrementingIdentifier",
        "price_per_day": 81.59,
        "user": {
            "userid": 12,
            "username": "caren.haag",
            "email": "hollie.dare@gmail.com",
            "firstname": "Ola",
            "lastname": "Oberbrunner",
            "address": "65921 Rhonda Track",
            "streetAddress": "49338 Walter Neck",
            "city": "West Antoine",
            "state": "Ohio",
            "zipcode": "15568-9784",
            "useremails": [
                {
                    "useremailid": 19,
                    "useremail": "vsrb70@gmail.com"
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
    }
]
```
</details>

<h6>Add a rental</h6>
<details>
<summary>POST /api/rentals/rental/3</summary>

AXIOS OBJECT SHAPE EXAMPLE

```JSON
{
    "name": "Green scarf",
    "description": "Minima est nobis eos. Maiores corporis quis exercitationem molestias possimus reiciendis corrupti. Impedit et et impedit. Quibusdam quidem blanditiis.",
    "image": "https://source.unsplash.com//200x200?sig=incrementingIdentifier",
    "price_per_day": 2.00
}
```

EXAMPLE REPONSE

```JSON
{
    "rentalid": 59,
    "name": "Green scarf",
    "description": "Minima est nobis eos. Maiores corporis quis exercitationem molestias possimus reiciendis corrupti. Impedit et et impedit. Quibusdam quidem blanditiis.",
    "image": "https://source.unsplash.com//200x200?sig=incrementingIdentifier",
    "price_per_day": 2.0,
    "user": {
        "userid": 3,
        "username": "admin",
        "email": "admin@lambdaschool.local",
        "firstname": "Admin",
        "lastname": "Admin",
        "address": "221B Baker Street",
        "streetAddress": "221B Baker Street",
        "city": "London",
        "state": "London",
        "zipcode": "88888",
        "useremails": [],
        "roles": [
            {
                "role": {
                    "roleid": 1,
                    "name": "OWNER"
                }
            }
        ]
    }
}
```

</details>

<h6>Update a rental</h6>
<details>
<summary>PUT /api/rental/3</summary>

AXIOS OBJECT SHAPE EXAMPLE

```JSON
{
    "name": "Red scarf",
    "description": "Minima est nobis eos. Maiores corporis quis exercitationem molestias possimus reiciendis corrupti. Impedit et et impedit. Quibusdam quidem blanditiis.",
    "image": "https://source.unsplash.com//200x200?sig=incrementingIdentifier",
    "price_per_day": 2.00
}
```

EXAMPLE RESPONSE

```JSON
{
    "rentalid": 13,
    "name": "Red scarf",
    "description": "Minima est nobis eos. Maiores corporis quis exercitationem molestias possimus reiciendis corrupti. Impedit et et impedit. Quibusdam quidem blanditiis.",
    "image": "https://source.unsplash.com//200x200?sig=incrementingIdentifier",
    "price_per_day": 2.0,
    "user": {
        "userid": 12,
        "username": "johnnie.zboncak",
        "email": "lawanna.schultz@gmail.com",
        "firstname": "Hwa",
        "lastname": "Wolf",
        "address": "824 Davis Land",
        "streetAddress": "449 Curtis Pines",
        "city": "Cruickshankfurt",
        "state": "South Carolina",
        "zipcode": "68275",
        "useremails": [
            {
                "useremailid": 20,
                "useremail": "nrba04@gmail.com"
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
}
```
</details>

<h6>Delete a rental</h6>
<details>
<summary>DELETE /api/rentals/rental/3</summary>

NO RESPONSE

</details>

<h6>Search by rental name</h6>
<details>
<summary>GET /api/rentals/search?name=Keyboard</summary>

EXAMPLE RESPONSE
```JSON
[
    {
        "rentalid": 14,
        "name": "Enormous Aluminum Keyboard",
        "description": "Minus nisi aliquid quis et aspernatur distinctio libero. Temporibus ut labore non. Sint ullam in. Nihil dolorum voluptatem.",
        "image": "https://source.unsplash.com//200x200?sig=incrementingIdentifier",
        "price_per_day": 23.53,
        "user": {
            "userid": 12,
            "username": "merrill.lowe",
            "email": "farrah.cruickshank@hotmail.com",
            "firstname": "Elfreda",
            "lastname": "Cruickshank",
            "address": "61941 Grant Shore",
            "streetAddress": "648 Koss Row",
            "city": "North Rafaelton",
            "state": "Oklahoma",
            "zipcode": "64673-0046",
            "useremails": [
                {
                    "useremailid": 19,
                    "useremail": "ocwi91@gmail.com"
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
    },
    {
        "rentalid": 43,
        "name": "Practical Paper Keyboard",
        "description": "Repellendus eos eaque. Beatae neque iusto sit. Dolor quis esse ex atque quo. Omnis sapiente quasi quaerat et voluptatem.",
        "image": "https://source.unsplash.com//200x200?sig=incrementingIdentifier",
        "price_per_day": 89.79,
        "user": {
            "userid": 42,
            "username": "caryn.wyman",
            "email": "kerri.schimmel@yahoo.com",
            "firstname": "Keneth",
            "lastname": "Champlin",
            "address": "993 Conn Village",
            "streetAddress": "01337 Earline Grove",
            "city": "Wallaceberg",
            "state": "Texas",
            "zipcode": "09096",
            "useremails": [
                {
                    "useremailid": 49,
                    "useremail": "vpyr58@gmail.com"
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
    }
]
```