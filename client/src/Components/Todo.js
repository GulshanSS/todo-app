import React from "react";

export const Todo = ({ title, content, status }) => {
  return (
    <div className="container p-6 border border-black rounded-lg shadow-md bg-gray-800">
      <span className="text-white text-2xl font-bold">{title || ""}</span>
      <p className="text-gray-500 text-1xl font-semibold mb-3">
        {content || ""}
      </p>
      <span className="border border-gray-500 text-white p-1">
        {status || ""}
      </span>
    </div>
  );
};
