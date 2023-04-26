#Requires -Version 7

$env:DOCKER_SCAN_SUGGEST="false"

docker pull postgres

docker pull eclipse-temurin:20-jdk-alpine

docker stop postit | Out-Null

docker stop postit-db | Out-Null

Start-Sleep 0.25

docker rm postit-db | Out-Null

docker rm postit | Out-Null

Start-Sleep 0.25

docker rmi postit-db-image:1.0.0 | Out-Null

docker rmi postit-image:1.0.0 | Out-Null

docker network rm postit-network | Out-Null

Start-Sleep 0.25

docker network create --driver bridge postit-network | Out-Null

Set-Location (Join-Path $PSScriptRoot database);

docker build -t postit-db-image:1.0.0 .

docker run -d --restart unless-stopped -p 5432:5432 --name postit-db `
--network postit-network postit-db-image:1.0.0 | Out-Null

Set-Location (Join-Path $PSScriptRoot frontend)

npm install --save-dev @angular/cli

npm run-script ng build

Copy-Item -Path (Join-Path $PSScriptRoot frontend dist *) `
    -Destination (Join-Path $PSScriptRoot backend src main resources static) `
    -PassThru -Force -Recurse

Set-Location (Join-Path $PSScriptRoot backend)

if ($IsWindows -eq $true) {
    ./mvnw.cmd package
}
else {
    ./mvnw package
}

docker build -t postit-image:1.0.0 .

docker run -d --restart unless-stopped --name postit -p 5001:5001 --network postit-network `
-e SPRING_DATASOURCE_URL="jdbc:postgresql://postit-db:5432/notes" postit-image:1.0.0 | Out-Null

Write-Host "Done. Open your browser at http://localhost:5001" -ForegroundColor DarkYellow

Set-Location $PSScriptRoot