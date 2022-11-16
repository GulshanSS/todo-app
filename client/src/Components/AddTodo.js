import React, { useState } from "react";

export const AddTodo = () => {
  const [formData, setFormData] = useState({
    title: "",
    content: "",
  });

  const handleFormSubmit = (e) => {
    e.preventDefault();
    console.log(formData);
  };

  return (
    <form className="grid grid-cols-1 gap-4 border border-black rounded-md align-middle p-5 bg-black w-80">
      <input
        className="px-1 py-2 rounded-md"
        type="text"
        name="title"
        placeholder="Enter Titile"
        value={formData.title}
        onChange={(e) =>
          setFormData((prev) => ({
            ...prev,
            title: e.target.value,
          }))
        }
      />
      <textarea
        className="px-1 py-2 rounded-md h-40"
        type="text"
        name="content"
        placeholder="Enter Content"
        value={formData.content}
        onChange={(e) =>
          setFormData((prev) => ({
            ...prev,
            content: e.target.value,
          }))
        }
      />
      <button
        className="bg-white rounded-md py-2"
        onClick={(e) => handleFormSubmit(e)}
      >
        Create
      </button>
    </form>
  );
};
