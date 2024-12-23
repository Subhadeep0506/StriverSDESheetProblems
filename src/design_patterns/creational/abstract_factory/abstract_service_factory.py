from __future__ import annotations
from abc import ABC, abstractmethod
from src.design_patterns.creational.abstract_factory.abstract_factory import (
    AbstractEmbeddingService,
    AbstractLLMService,
)


class AbstractAIServiceFactory(ABC):
    @abstractmethod
    def create_embedding_service(self) -> AbstractEmbeddingService:
        pass

    @abstractmethod
    def create_llm_service(self) -> AbstractLLMService:
        pass
