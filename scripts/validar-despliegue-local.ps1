Write-Host "Validando despliegue local del microservicio Biblioteca DUOC..."

$baseUrl = "http://localhost:8082"
$endpoint = "$baseUrl/api/v1/solicitudes"

Write-Host "Probando endpoint: $endpoint"

try {
    $response = Invoke-WebRequest -Uri $endpoint -Method GET -UseBasicParsing

    Write-Host "Estado HTTP:" $response.StatusCode
    Write-Host "Respuesta:"
    Write-Host $response.Content

    if ($response.StatusCode -eq 200) {
        Write-Host "Validacion correcta: el microservicio responde en entorno local."
    } else {
        Write-Host "El microservicio respondio, pero con un estado distinto a 200."
    }
}
catch {
    Write-Host "No se pudo conectar al microservicio."
    Write-Host "Verifica que Docker Compose este levantado y que la aplicacion use el puerto 8082."
}