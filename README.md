# Clínica API — Checkpoint 04

## Video Demonstrativo
https://youtu.be/U9bJg7ot5n8 

## Requisitos
- Java 21
- Maven 3.9+
- Docker (para rodar testes com Testcontainers) e PostgreSQL local (para desenvolvimento)

## Endpoints 

| Recurso        | Endpoint            | Método | 

|----------------|---------------------|--------|

| Criar paciente  | `/pacientes`          | POST   | 

| Listar pacientes | `/jogador`        | GET    |

| Buscar paciente por ID | `/pacientes/{id}` | GET |

| Atualizar paciente | `/pacientes/{id}`   | PUT    |

| Deletar paciente  | `/pacientes/{id}`    | DELETE |

| Criar medico  | `/medico`          | POST   | 

| Listar medicos | `/medico`        | GET    |

| Buscar medico por ID | `/medico/{id}` | GET |

| Atualizar medico | `/medico/{id}`   | PUT    |

| Deletar medico  | `/medico/{id}`    | DELETE |

| Cria Consulta  | `/consulta`    | POST |



## Alterações Realizadas

- Inclusão Controller de Médico e Consulta

- Coreção DTO´s

- Correçao camada repository



# Aluno

- RM97956 - Maria Fernanda Vieira de Camargo
