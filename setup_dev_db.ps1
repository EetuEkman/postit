Set-Location (Join-Path $PSScriptRoot .\database)

docker pull postgres

docker stop postit-db | Out-Null

Start-Sleep 0.25

docker rm postit-db | Out-Null

docker rmi postit-db-image:1.0.0 | Out-Null

Start-Sleep 0.25

$env:DOCKER_SCAN_SUGGEST="false"

docker build -t postit-db-image:1.0.0 .

docker run -d -p 5432:5432 --name postit-db postit-db-image:1.0.0 | Out-Null

Set-Location $PSScriptRoot