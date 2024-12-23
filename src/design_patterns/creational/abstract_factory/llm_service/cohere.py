from abstract_factory import AbstractLLMService


class CohereLLMService(AbstractLLMService):
    def generate_text(self, prompt: str) -> str:
        return "Cohere response"  # Dummy implementation
