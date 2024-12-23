from abstract_factory import AbstractLLMService


class GroqLLMService(AbstractLLMService):
    def generate_text(self, prompt: str) -> str:
        return "Groq response"  # Dummy implementation
