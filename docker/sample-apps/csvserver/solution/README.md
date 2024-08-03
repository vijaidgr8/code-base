# Commands Executed

## Part I

### Pulled the Container Images into Local
docker pull infracloudio/csvserver:latest
docker pull prom/prometheus:v2.22.0
### Executed the Container
docker run -d infracloudio/csvserver:latest
Container Failed.
### Checked the logs for the container
docker logs 3fcd
In Logs can able to determine the failure
Reason for the Failiure : 2023/06/05 14:55:14 error while reading the file "/csvserver/inputdata": open /csvserver/inputdata: no such file or directory
### Executed the run with the inputFile Generated from the script (gencsv.sh)
docker run -d -v /Users/vijai/Personal/Learning/Playgrounds/infocloud-assessment/solutions/inputFile:/csvserver/inputdata infracloudio/csvserver:latest
### Got into the container to get the port
docker exec -it 3fcd bash
#### Inside the container executed this to get the port
netstat -tuln
got the port number as 9300
### Finally executed the container with port number mapping as per requirement 
docker run -d -v /Users/vijai/Personal/Learning/Playgrounds/infocloud-assessment/solutions/inputFile:/csvserver/inputdata -p 9393:9300 infracloudio/csvserver:latest
### Executed the container again with the environment variable
docker run -d -v /Users/vijai/Personal/Learning/Playgrounds/infocloud-assessment/solutions/inputFile:/csvserver/inputdata -p 9393:9300 -e CSVSERVER_BORDER=Orange infracloudio/csvserver:latest

## Part II

### Created Docker Compose and executed it.
docker compose up -d

