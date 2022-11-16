import React, { useEffect, useState } from "react";
import { Todo } from "../Components/Todo";
import Axios from "axios";
import axios from "axios";

export const TodoPage = () => {
  const [todos, setTodos] = useState([]);

  const getAllTodos = () => {
    axios
      .get("http://localhost:8080/api/v1/todo")
      .then((response) => setTodos(response.data))
      .catch((err) => console.log(err.message));
  };

  useEffect(() => {
    getAllTodos();
  }, []);

  return (
    <div className="grid lg:grid-cols-3 md:grid-cols-2 gap-4 my-5 sm:mx-2">
      {todos.length > 0 ? (
        todos.map((todo) => (
          <Todo
            key={todo.id}
            title={todo.title}
            content={todo.content}
            status={todo.todoStatus}
          />
        ))
      ) : (
        <h1>No Todo's Available</h1>
      )}
    </div>
  );
};
