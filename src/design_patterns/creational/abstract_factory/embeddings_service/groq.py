from abstract_factory import AbstractEmbeddingService


class GroqEmbeddingService(AbstractEmbeddingService):
    def generate_embeddings(self, text: str) -> list[float]:
        return [0.4, 0.5, 0.6]  # Dummy implementation
