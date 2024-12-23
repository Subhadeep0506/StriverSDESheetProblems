from src.design_patterns.creational.abstract_factory.abstract_factory import (
    AbstractEmbeddingService,
    AbstractLLMService,
)


class GeminiEmbeddingService(AbstractEmbeddingService):
    def generate_embeddings(self, text: str) -> list[float]:
        return [0.1, 0.2, 0.3]  # Simulate response


class GeminiLLMService(AbstractLLMService):
    def generate_text(self, prompt: str) -> str:
        return f"Gemini LLM response to '{prompt}'"
