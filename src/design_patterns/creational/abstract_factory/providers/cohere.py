from ..abstract_factory import (
    AbstractEmbeddingService,
    AbstractFactory,
    AbstractLLMService,
)
from ..embeddings_service.cohere import CohereEmbeddingService
from ..llm_service.cohere import CohereLLMService


class CohereFactory(AbstractFactory):
    def create_embedding_service(self) -> AbstractEmbeddingService:
        return CohereEmbeddingService()

    def create_llm_service(self) -> AbstractLLMService:
        return CohereLLMService()
