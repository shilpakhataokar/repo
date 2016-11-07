# API's to find Shops Near You 
Gives you the facility to add a shop with address. 
Stores the longitude and latitude of your shop using Google [Geocoding API](https://developers.google.com/maps/documentation/geocoding/intro). 
You can request for a shop mentioning your current latitude and longitude. The API would return you the shop nearest to you.

To add a resource
Resource			: /shop
Description			: Adds a given shop. The API would find the latitude and longitude of the shop address using Google Maps API 
                                  and store it with the address.
Method				: POST
Request Content-type: application/json
Example Request		:{
			  "shopName": "Amphitheatre Parkway",
			  "shopAddress": {
					  "number": "1600",
					  "addressLine1" : "Mountain View",
					  "addressLine2" : "CA",
					  "postCode": "94043"
					 }
			 }
Success Response	: {
                            "shopName": "Amphitheatre Parkway"
                            "shopLongitude": -122.0841329
                            "shopLatitude": 37.4174166
                            "shopAddress": {
                            "number": "1600"
                            "postCode": "94043"
                            "addressLine1": "Mountain View"
                            "addressLine2": "CA"
                            }
                           }

To get a resource
Resource				: /shop/{latitude}/{longitude}
Description				: Gives you the nearest shop from your latitude and longitude.
Method					: GET
Response Content-type	: application/json;charset=UTF-8
Example Response		: 200 OK	
				{
				  "shopName": "Amphitheatre Parkway",
				  "shopAddress": {
						    "number": "1600",
						    "addressLine1" : "Mountain View",
						    "addressLine2" : "CA",
						    "postCode": "94043"
						  }
				}
```

To get resources list
```
Resource				: /allshops
Description				: Gives you the list of available shops
Method					: GET
Response Content-type	: application/json;charset=UTF-8
Example Response		: 200 OK	
[2]
0:  {
"shopName": "Aspire Towers "
"shopLongitude": 73.9481694
"shopLatitude": 18.5182989
"shopAddress": {
"number": null
"postCode": "411028"
"addressLine1": "Amanora Park town Trendy Towers "
"addressLine2": "Pune"
}-
}-
1:  {
"shopName": "Amphitheatre Parkway"
"shopLongitude": -122.0841329
"shopLatitude": 37.4174166
"shopAddress": {
"number": "1600"
"postCode": "94043"
"addressLine1": "Mountain View"
"addressLine2": "CA"
}-
}

## How to run
You need Java 8 for running this project.

**Maven :**
If using maven you can use below command to run it

`mvn spring-boot:run -Dserver.port=8082`

**Gradle :**
If using gradle use below command to run it

`gradle bootRun`

**As jar :**
You can directly run it as a jar using below command. Change the path to the jar accordingly

`java -jar -Dserver.port=8082 shops-near-you.jar`

If you do not change the port using `-Dserver.port=8082` by default the embedded Tomcat runs on port `8080`


## Google map's Geocoding API
The Google Maps [Geocoding API](https://developers.google.com/maps/documentation/geocoding/start) is a service that 
provides you the latitude and longitude of an address which is called geocoding. 
It also supports reverse geocoding i.e. gives you the address from the latitude and longitude provided. 
To use this Geocoding API you need to first [register](https://developers.google.com/maps/documentation/geocoding/get-api-key) your application with Google using your Google ID.
After registration Google gives you an API key which you need to update in the `application.properties` file as
```
config.apikey=<your key goes here>

## The distance comparison logic
The [Great-circle distance](https://en.wikipedia.org/wiki/Great-circle_distance) or orthodromic distance is the shortest distance between two points 
on the surface of a sphere, measured along the surface of the sphere (as opposed to a straight line through the sphere's interior). 
[Haversine formula](https://en.wikipedia.org/wiki/Haversine_formula) is used to calculate the Great-circle distance between two points on a sphere
 from their longitudes and latitudes. Refer this [article](http://www.movable-type.co.uk/scripts/latlong.html) for the formula.