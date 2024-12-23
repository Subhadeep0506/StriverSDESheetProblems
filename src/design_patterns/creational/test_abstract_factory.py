from src.design_patterns.creational.abstract_factory.abstract_factory import (
    AbstractFactory,
)
from src.design_patterns.creational.abstract_factory.providers.cohere import (
    CohereFactory,
)
from src.design_patterns.creational.abstract_factory.providers.gemini import (
    GeminiFactory,
)
from src.design_patterns.creational.abstract_factory.providers.groq import GroqFactory


def client_code(factory: AbstractFactory) -> None:
    embedding_service = factory.create_embedding_service()
    llm_service = factory.create_llm_service()
    print(f"Embeddings: {embedding_service.generate_embeddings('example text')}")
    print(f"Generated Text: {llm_service.generate_text('example prompt')}")


if __name__ == "__main__":
    print("Client: Testing Groq Factory")
    client_code(GroqFactory())
    print("\n")
    print("Client: Testing Gemini Factory")
    client_code(GeminiFactory())
    print("\n")
    print("Client: Testing Cohere Factory")
    client_code(CohereFactory())
