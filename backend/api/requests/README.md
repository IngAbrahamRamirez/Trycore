# API Requests

Colección de pruebas manuales para la API.

---

## Orden recomendado

1. Ejecutar User
2. Ejecutar Project
3. Ejecutar Activity
4. Ejecutar Earned Value

---

## Variables

Cada archivo contiene variables que deben actualizarse con los IDs retornados.

Ejemplo

```http
@userId=
```

Después de crear un usuario copiar el UUID retornado.

---

## Flujo recomendado

User

↓

Project

↓

Activity

↓

Earned Value

---

Todos los endpoints deben probar:

- CREATE
- FIND ALL
- FIND BY ID
- UPDATE
- DELETE
- NEGATIVE TESTS