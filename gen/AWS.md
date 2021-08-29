Amazon Web Services
	• Provides on demand cloud computing platforms and APIs to individuals, companies, and governments, on a metered pay-as-you-go basis. Method of obtaining large scale computing capacity more quickly, cheaply, and reliably than building an actual physical server farm.
	• https://www.geeksforgeeks.org/what-are-the-important-aws-cloud-services/
  +;
Compute,
		○ Amazon EC2 (Elastic Cloud Compute):
			§ Web service that provides secure, resizable compute capacity in the cloud. Can resize capacity needs quickly, can use one or hundreds or thousands of server instances simultaneously.
		○ AWS Lambda
			§ Run code without managing servers. Only pay for the time when code is running. Lambda runs and scales code itself.
    +;
Storage,
		○ Amazon S3 (Simple Storage Service)
			§ Storage for cloud-native applications
		○ Glacier
			§ For data that will rarely need to be accessed. Very cheap.
    +;
Databases
		○ Amazon Aurora
			§ Relational database for the cloud. Faster replication and more storage nodes than RDS.
		○ Amazon RDS (Relation Database Service)
			§ Set up, operate, and scale a relational database in the cloud.
		○ PosgreSQL, MySQL, MariaDB, Oracle, Microsoft SQL Server, Amazon Aurora
		○ Amazon DynamoDB (non relational database)
			§ For apps that need consistent, single-digit millisecond latency at any scale
    +;
Networking,
		○ Amazon VPC. Simulates on prem private network, in the cloud
		○ Amazon Route 53. DNS (Domain Name Service).
    +;
Other,
		○ CloudFront: CDN (Content Delivery Network)
		○ SNS (Simple Notification Service)
		○ SQS (Simple Queuing Service)
		○ Elasticsearch
		○ Load Balancer
		○ Data Pipeline
		○ Kinesis: for processing big data in real time. Hundreds of terabytes per hour
    +;
Other other,
  • What is capacity engineering, truly
  	• https://www.quora.com/What-is-the-role-of-Performance-and-Capacity-Engineer-at-Facebook
  • Data pipelines
  	• Batch vs real time
  	• ETL (data are extracted, transformed, and loaded)
  	• AWS Data Pipeline
  • Visualization and reporting
    	• Tableau, HighCharts, AWS Data Visualization
  • Docker/containerization
  +;
Relational vs. Non relational db,
	• Relational databases
		○ Def: use Structured Querying Language (SQL), the structure of a relational database allows you to link information from different tables through the use of foreign keys (or indexes).
		○ Pros:
			§ Better option to handle a lot of complicated querying, database transactions, and routing analysis of data.
			§ Faster for joins, queries, updates etc..
			§ ACID(Atomity, Consistency, Isolation, Durability): Set of properties that ensure reliable database transactions.
		○ Cons:
			§ Referential integrity can be hard to manage (cascading actions of adding, deleting, and updating when there are many relationships between separate tables).
			§ Cannot store complex or very large images, numbers, designs and multimedia products
  Non-relational databases
		○ Def: data without explicit and structured mechanisms to link data from different tables to one another
		○ Pros:
			§ Large volumes of structured, semi-structured, and unstructured data
			§ Avoids impedance mismatching
			§ Just JSON
			§ Superior horizontal scalability. Can keep sharding the data ad infinitum.
			§ No SQL injections possible
		○ Cons:
			§ No joins, so manually querying and joining within code can get messy quickly
			§ More database management re: committing changes, rolling back, etc.
      +;
Elastic,
	• ELK stack (Elasticsearch, Logstash, Kibana). Popular, open-source framework for log analytics
  +;
Elastic Search,
	• Document-oriented search engine, designed to store, retrieve, and manage document-oriented, structured, unstructured, and semi-structured data
	• Search engine based on the Apache Lucene library. It provides distributed, multitenant-capable full-text search engine with an http web interface and schema-free JSON documents.
  +;
Kibana,
	• Open source data visualization dashboard for Elasticsearch. It provides visualization capabilities on top of content indexed on an Elasticsearch cluster.
  +;
Load Balancer,
	• Efficiently distributing incoming network traffic to a group of backend servers
  +;
