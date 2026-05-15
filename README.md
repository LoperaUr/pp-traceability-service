# Traceability Service Microservicio

Microservicio encargado de gestionar el historial de cambios de estado de pedidos (HU #17).

## Documentacion consolidada

- Requisitos compartidos: `..\requirements.md`

## Estado funcional vs requirements

| HU | Endpoint / Regla | Estado |
|---|---|---|
| #17 | Registrar cada cambio de estado del pedido | OK |
| #17 | Cliente consulta historial solo de sus pedidos | OK |

## Variables de entorno

- `MONGODB_URI`
- `JWT_SECRET`
- `JWT_EXPIRATION`

## Endpoints

- `POST /api/v1/traceability`
- `GET /api/v1/traceability/orders/{orderId}`

