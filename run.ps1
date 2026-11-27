$ErrorActionPreference = 'Stop'

$projectRoot = Split-Path -Parent $MyInvocation.MyCommand.Path
$sourceRoot = Join-Path $projectRoot 'src/main/java'
$outputDirectory = Join-Path $projectRoot 'target/classes'

New-Item -ItemType Directory -Force -Path $outputDirectory | Out-Null
$sources = Get-ChildItem -Path $sourceRoot -Recurse -Filter '*.java' | ForEach-Object { $_.FullName }
if ($sources.Count -eq 0) {
    throw "No Java source files found under $sourceRoot"
}

& javac -d $outputDirectory @sources
if ($LASTEXITCODE -ne 0) {
    exit $LASTEXITCODE
}

& java -cp $outputDirectory com.foodfinda.Main
exit $LASTEXITCODE
