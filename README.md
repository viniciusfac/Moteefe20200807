# Moteefe20200807
Engineering Team Lead - Moteefe

Program created using SpringBoot, and Java 8.

There are a single end point /orderdelivery, that returns a Json Rest, defined at problem proposal.

This end point accepts two verbs:
- GET
	Returns a mock result, using the requested format

- POST
	Returns a result based on a supplier/product defined at problem proposal.
	The defined Json can be used as a requested, for instance:
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
				}
			]
		}
}