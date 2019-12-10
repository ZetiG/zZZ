#前缀
prefix="http://106.13.22.217/zzz/"
#版本号
version="v1.0.0"

docker  build --rm=true  -t $prefix"zzz:"$version ../zzz

docker login --username=admin --password=Admin123  http://106.13.22.217

docker push $prefix"zzz:"$version

docker rmi $prefix"zzz:"$version

#清理
docker system prune -f
