from ..abstract_factory import (
    AbstractEmbeddingService,
    AbstractFactory,
    AbstractLLMService,
)
from ..embeddings_service.groq import GroqEmbeddingService
from ..llm_service.groq import GroqLLMService


class GroqFactory(AbstractFactory):
    def create_embedding_service(self) -> AbstractEmbeddingService:
        return GroqEmbeddingService()

    def create_llm_service(self) -> AbstractLLMService:
        return GroqLLMService()
