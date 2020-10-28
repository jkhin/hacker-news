#!/bin/bash
PACKAGE="io/jk/dev/reign/hackernews"
createFolder () {
    FolderPath=$1
    echo "Verificando si existe el folder $FolderPath"
    
    if [[ -d "$FolderPath" ]]; then
        echo "El folder $FolderPath ya existe"
    else
        echo "Creando folder $FolderPath"
        mkdir ${FolderPath}
        echo "Folder creado -> $FolderPath"
    fi
}
echo "versión 1.0"
if [[ "$1" == "" ]]; then
    echo "Debe incluir el nombre del feature"
    exit
fi
FeatureName=$1
#Create RES structure
# mkdir -p "res/layouts/$FeatureName/layout"
# mkdir -p "res/layouts/$FeatureName/drawable"
# mkdir -p "res/layouts/$FeatureName/layout-w960dp"
# mkdir -p "res/layouts/$FeatureName/presentation/layout"
# mkdir -p "res/layouts/$FeatureName/presentation/layout-w960dp"
#create features
mkdir -p "kotlin/$PACKAGE/features"
cd "kotlin/$PACKAGE/features"
#Folder feature
createFolder "$FeatureName"
#Folder presentation
createFolder "$FeatureName/presentation"
#Folder presentation folders
createFolder "$FeatureName/presentation/adapters"
createFolder "$FeatureName/presentation/activities"
createFolder "$FeatureName/presentation/fragments"
createFolder "$FeatureName/presentation/dialogfragments"
createFolder "$FeatureName/presentation/model"
createFolder "$FeatureName/presentation/model/mapper"
createFolder "$FeatureName/presentation/viewmodel"
createFolder "$FeatureName/presentation/viewmodel/viewstate"
#Folder domain
createFolder "$FeatureName/domain"
#Foder domain folders
createFolder "$FeatureName/domain/repository"
createFolder "$FeatureName/domain/model"
createFolder "$FeatureName/domain/interactor"
#Folder domain
createFolder "$FeatureName/data"
#Foder domain folders
createFolder "$FeatureName/data/datasource"
createFolder "$FeatureName/data/datasource/account"
createFolder "$FeatureName/data/datasource/database"
createFolder "$FeatureName/data/datasource/database/dto"
createFolder "$FeatureName/data/datasource/database/mapper"
createFolder "$FeatureName/data/datasource/rest"
createFolder "$FeatureName/data/datasource/rest/interfaces"
createFolder "$FeatureName/data/datasource/rest/request"
createFolder "$FeatureName/data/datasource/rest/response"
createFolder "$FeatureName/data/datasource/s3"
createFolder "$FeatureName/data/mapper"
createFolder "$FeatureName/data/repository"
echo "add these lines to gradle"
# echo "main.res.srcDirs += 'src/main/res/layouts/$FeatureName/presentation'"
echo -n "main.res.srcDirs += 'src/main/res/layouts/$FeatureName'" | pbcopy
echo "copy to clipboard"