import React from "react";
import { Todo } from "../Components/Todo";

export const TodoPage = () => {
  return (
    <div className="grid lg:grid-cols-3 md:grid-cols-2 gap-4 my-5 sm:mx-2">
      <Todo title="Todo 1" content="This is my first todo" status="Pending" />
    </div>
  );
};
