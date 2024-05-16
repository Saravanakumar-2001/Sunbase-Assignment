Sunbase Assignment:

This project implements a basic RAG model AI chatbot using open-source technologies. Here's an overview of the project's implementation:

Database:
For the vector database, Supabase is utilized. Supabase offers a scalable and easy-to-use platform for storing vector data efficiently.

Backend:
The backend of the chatbot is developed in Java. It provides the necessary APIs for handling text processing and chat interactions.

Frontend:
The frontend interface is built using HTML/CSS/JS. It includes basic pages for uploading documents or text for training the RAG model and a chat interface for interacting with the chatbot.

Backend API:

Upload Functionality: The backend provides an API for uploading files or text. Text is processed into chunks and embeddings using open-source embedding models. These embeddings are then stored in Supabase, offering flexibility and performance in vector data storage.
Chat API: The chat API handles user queries or prompts. User input is processed and passed to the chatbot engine, which generates responses using prompt engineering techniques and language models.
Frontend:
The frontend interface is designed to be simple yet functional:

Upload Page: Users can upload documents or text files to train the RAG model. This page facilitates the training process by providing an intuitive interface for data input.
Chat Interface: The chat interface allows users to interact with the chatbot. Users can send messages and receive responses in real-time, facilitating seamless communication with the AI.
