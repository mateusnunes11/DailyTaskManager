const express = require('express');
const router = express.Router();
const Task = require('../models/Task');
const authMiddleware = require('../middlewares/auth'); // Middleware para verificar o token

// Middleware para autenticação
router.use(authMiddleware);

// Criar tarefa
router.post('/', async (req, res) => {
    const { title, description, dueDate, category } = req.body;
    try {
        const newTask = new Task({ title, description, dueDate, category, user: req.user.id });
        await newTask.save();
        res.status(201).json(newTask);
    } catch (error) {
        res.status(400).json({ message: 'Erro ao criar tarefa' });
    }
});

// Ler todas as tarefas
router.get('/', async (req, res) => {
    try {
        const tasks = await Task.find({ user: req.user.id }).populate('category');
        res.json(tasks);
    } catch (error) {
        res.status(500).json({ message: 'Erro ao buscar tarefas' });
    }
});

// Atualizar tarefa
router.put('/:id', async (req, res) => {
    const { title, description, dueDate, category } = req.body;
    try {
        const updatedTask = await Task.findByIdAndUpdate(req.params.id, { title, description, dueDate, category }, { new: true });
        res.json(updatedTask);
    } catch (error) {
        res.status(400).json({ message: 'Erro ao atualizar tarefa' });
    }
});

// Deletar tarefa
router.delete('/:id', async (req, res) => {
    try {
        await Task.findByIdAndDelete(req.params.id);
        res.status(204).send();
    } catch (error) {
        res.status(400).json({ message: 'Erro ao deletar tarefa' });
    }
});

module.exports = router;

