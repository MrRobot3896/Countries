Api to use used :

http://localhost:8080/country/{country Name}

For e.g

http://localhost:8080/country/United States of America

---------------------------------------------------------------------------------------------------
Response Output :

List of Neighbour Country Having
{
        "name": Officail Name Of Neighbour Country,
        "commonLanguage": Boolean field of sharing any common language,
        "commonside": Boolean field of car driving same side,
        "distance": approx distance between the two countries ,
        "parentCountryName": The country which was queried
}

For e.g response for http://localhost:8080/country/United States of America

    {
        "name": "Canada",
        "commonLanguage": true,
        "commonside": true,
        "distance": 208.19561666812783,
        "parentCountryName": "United States of America"
    },
    {
        "name": "United Mexican States",
        "commonLanguage": false,
        "commonside": true,
        "distance": 382.6833203025311,
        "parentCountryName": "United States of America"
    }
]

---------------------------------------------------------------------------------------------------
Distance calculation ( Haversine formula ) :

Calculated the approx distance between two countries using latitute and longitute given using the Haversine formula.
->Used the strategy pattern here thus we can use any other formula in future.

-------------------------------------------------------------------------------------------------





