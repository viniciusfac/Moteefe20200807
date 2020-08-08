# Moteefe20200807
Engineering Team Lead - Moteefe

Program created using SpringBoot (2.1.3), and Java 8.

There are a single end point /orderdelivery, that returns a Json Rest, defined at problem proposal.

This end point accepts two verbs:
- GET
	Returns a mock result, using the requested format

- POST
	Returns a result based on a supplier/product defined at problem proposal.
	The defined Json can be used as a requested, for example:

IN: 
{
	"region": "us",
	"basket": {
			"items": [
				{
					"produsct": "black_mug",
					"ciount": 1
				},
				{
					"produsct": "pink_t-shirt",
					"ciount": 2
				},
				{
					"produsct": "blue_t-shirt",
					"ciount": 3
				},
				{
					"produsct": "white_mug",
					"ciount": 4
				}
			]
		}
}

OUT:
{
    "delivery_date": "2020-08-16",
    "shipments": [
        {
            "suplier": "Shirts4U",
            "delivery_date": "2020-08-14",
            "items": [
                {
                    "title": "black_mug",
                    "count": 1
                }
            ]
        },
        {
            "suplier": "Best Tshirts",
            "delivery_date": "2020-08-13",
            "items": [
                {
                    "title": "pink_t-shirt",
                    "count": 2
                },
                {
                    "title": "blue_t-shirt",
                    "count": 3
                }
            ]
        },
        {
            "suplier": "Shirts Unlimited",
            "delivery_date": "2020-08-16",
            "items": [
                {
                    "title": "white_mug",
                    "count": 4
                }
            ]
        }
    ]
}