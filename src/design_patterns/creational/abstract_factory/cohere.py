from src.design_patterns.creational.abstract_factory.abstract_factory import (
    AbstractEmbeddingService,
    AbstractLLMService,
)


class CohereEmbeddingService(AbstractEmbeddingService):
    def generate_embeddings(self, text: str) -> list[float]:
        return [0.7, 0.8, 0.9]  # Simulate response


class CohereLLMService(AbstractLLMService):
    def generate_text(self, prompt: str) -> str:
        return f"Cohere LLM response to '{prompt}'"
