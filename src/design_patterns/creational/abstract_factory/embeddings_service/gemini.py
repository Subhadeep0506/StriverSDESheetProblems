from abstract_factory import AbstractEmbeddingService

class GeminiEmbeddingService(AbstractEmbeddingService):
    def generate_embeddings(self, text: str) -> list[float]:
        return [0.1, 0.2, 0.3]  # Dummy implementation