from abstract_factory import AbstractEmbeddingService


class CohereEmbeddingService(AbstractEmbeddingService):
    def generate_embeddings(self, text: str) -> list[float]:
        return [0.7, 0.8, 0.9]  # Dummy implementation
