#language: pt

Funcionalidade: Propondo lances ao leilao

  Cenario: Propondo um unico lance valido
    Dado um lance valido
    Quando propoem ao leilao
    Entao o lance eh aceito

  Cenario: Propondo varios lances validos
    Dado um lance de 10.0 reais do usuario "fulano"
    E um lance de 15.0 reais do usuario "beltrano"
    Quando propoem varios lances ao leilao
    Entao os lances sao aceitos

  Esquema do Cenario: Propondo um lance invalido
    Dado um lance invalido de <valor> reais e do usuario '<nomeUsuario>'
    Quando propoem ao leilao
    Entao o lances nao eh aceito

    Exemplos:
      | valor | nomeUsuario |
      | 0.0   | beltrano    |
      | -1.0  | cigano      |

  Cenario: Propondo uma sequencia de lances
    Dado dois lances
      | valor | nomeUsuario |
      | 10.0  | beltrano    |
      | 15.0  | beltrano    |
    Quando propoem varios lances ao leilao
    Entao o segundo lance nao eh aceito