from abc import ABC, abstractmethod


class AbstractEmbeddingService(ABC):
    @abstractmethod
    def generate_embeddings(self, text: str) -> list[float]:
        pass


class AbstractLLMService(ABC):
    @abstractmethod
    def generate_text(self, prompt: str) -> str:
        pass
