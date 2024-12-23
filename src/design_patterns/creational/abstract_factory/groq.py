from src.design_patterns.creational.abstract_factory.abstract_factory import (
    AbstractEmbeddingService,
    AbstractLLMService,
)


class GroqEmbeddingService(AbstractEmbeddingService):
    def generate_embeddings(self, text: str) -> list[float]:
        return [0.4, 0.5, 0.6]  # Simulate response


class GroqLLMService(AbstractLLMService):
    def generate_text(self, prompt: str) -> str:
        return f"OpenAI LLM response to '{prompt}'"
