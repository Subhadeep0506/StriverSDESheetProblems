from abstract_factory import AbstractLLMService

class GeminiLLMService(AbstractLLMService):
    def generate_text(self, prompt: str) -> str:
        return "Gemini response"  # Dummy implementation