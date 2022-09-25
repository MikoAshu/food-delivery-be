echo "***** Starting development environment *****"
date
echo "[1] Create docker network (bookstore-network)"
docker network create -d bridge bookstore-network

# Start API Gateway 
echo "[4] Create API Gateway"
docker stop api-gateway
docker rm api-gateway
docker build -t api-gateway gateway/
docker run -d --name api-gateway --net=bookstore-network  -p 443:443 api-gateway


echo "The following containers are running..."

docker ps


# Testing...
echo "[5] Testing API Gateway (Must get a 200 OK HTTTP Response)"
