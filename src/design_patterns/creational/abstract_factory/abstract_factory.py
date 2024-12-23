from __future__ import annotations

from abc import ABC, abstractmethod


# Abstract Products
class AbstractEmbeddingService(ABC):
    @abstractmethod
    def generate_embeddings(self, text: str) -> list[float]:
        pass


class AbstractLLMService(ABC):
    @abstractmethod
    def generate_text(self, prompt: str) -> str:
        pass


# Abstract Factory
class AbstractFactory(ABC):
    @abstractmethod
    def create_embedding_service(self) -> AbstractEmbeddingService:
        pass

    @abstractmethod
    def create_llm_service(self) -> AbstractLLMService:
        pass
