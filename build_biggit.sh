#!/bin/bash
#大仓库更新脚本
set -ex
project=$(echo $1 | sed 's/\\n.*//g' )

whatdo=$2

version=$(echo $3 | sed 's/["]//g' )

BuildPath=${PWD}

if [ -z ${project} ]
then
  echo "******项目路径为空******";
  exit 128
fi

case ${project} in
"zzz")
cd zzz ;
echo "******zzz******";
;;
*)
cd ${project};
echo "******进入其它目录******";
;;
esac

if [ ${whatdo} == "build" ]
then
mvn clean package -Dmaven.test.skip=true -Dmaven.repo.local=${BuildPath}/.m2/repository;
elif [ ${whatdo} == "docker" ]
then
docker build --rm=true -t http://106.13.22.217/zzz/${project}:${version} . ;
docker login --username=${PLUGIN_DOCKER_USERNAME} --password=${PLUGIN_DOCKER_PASSWORD}  http://106.13.22.217/
docker push http://106.13.22.217/zzz/${project}:${version};
docker rmi http://106.13.22.217/zzz/${project}:${version};
docker system prune -f;
else
echo "****** 更新结束 ******";
fi

exit 0
