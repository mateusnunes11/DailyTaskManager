const express = require('express');
const router = express.Router();
const Category = require('../models/Category');
const authMiddleware = require('../middlewares/auth');

// Middleware para autenticação
router.use(authMiddleware);

// Criar categoria
router.post('/', async (req, res) => {
    const { name } = req.body;
    try {
        const newCategory = new Category({ name });
        await newCategory.save();
        res.status(201).json(newCategory);
    } catch (error) {
        res.status(400).json({ message: 'Erro ao criar categoria' });
    }
});

// Ler todas as categorias
router.get('/', async (req, res) => {
    try {
        const categories = await Category.find();
        res.json(categories);
    } catch (error) {
        res.status(500).json({ message: 'Erro ao buscar categorias' });
    }
});

// Atualizar categoria
router.put('/:id', async (req, res) => {
    const { name } = req.body;
    try {
        const updatedCategory = await Category.findByIdAndUpdate(req.params.id, { name }, { new: true });
        res.json(updatedCategory);
    } catch (error) {
        res.status(400).json({ message: 'Erro ao atualizar categoria' });
    }
});

// Deletar categoria
router.delete('/:id', async (req, res) => {
    try {
        await Category.findByIdAndDelete(req.params.id);
        res.status(204).send();
    } catch (error) {
        res.status(400).json({ message: 'Erro ao deletar categoria' });
    }
});

module.exports = router;
