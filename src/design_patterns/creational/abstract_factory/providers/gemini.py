from ..abstract_factory import (
    AbstractEmbeddingService,
    AbstractFactory,
    AbstractLLMService,
)
from ..embeddings_service.gemini import GeminiEmbeddingService
from ..llm_service.gemini import GeminiLLMService


class GeminiFactory(AbstractFactory):
    def create_embedding_service(self) -> AbstractEmbeddingService:
        return GeminiEmbeddingService()

    def create_llm_service(self) -> AbstractLLMService:
        return GeminiLLMService()
