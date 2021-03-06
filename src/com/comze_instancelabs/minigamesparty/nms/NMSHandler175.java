package com.comze_instancelabs.minigamesparty.nms;

import net.minecraft.server.v1_7_R2.Block;
import net.minecraft.server.v1_7_R2.Chunk;
import net.minecraft.server.v1_7_R2.ChunkCoordIntPair;
import net.minecraft.server.v1_7_R2.EnumSkyBlock;

import org.bukkit.World;
import org.bukkit.craftbukkit.v1_7_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_7_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class NMSHandler175 implements NMSAbstraction {

	@Override
	public boolean setBlockFast(World world, int x, int y, int z, int blockId, byte data) {
		net.minecraft.server.v1_7_R2.World w = ((CraftWorld) world).getHandle();
		Chunk chunk = w.getChunkAt(x >> 4, z >> 4);
		return chunk.a(x & 0x0f, y, z & 0x0f, Block.e(blockId), data);
	}

	@Override
	public void forceBlockLightLevel(World world, int x, int y, int z, int level) {
		net.minecraft.server.v1_7_R2.World w = ((CraftWorld) world).getHandle();
		w.b(EnumSkyBlock.BLOCK, x, y, z, level);
	}

	@Override
	public int getBlockLightEmission(int blockId) {
		return Block.e(blockId).m();
	}

	@Override
	public int getBlockLightBlocking(int blockId) {
		return Block.e(blockId).k();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void queueChunkForUpdate(Player player, int cx, int cz) {
		((CraftPlayer) player).getHandle().chunkCoordIntPairQueue.add(new ChunkCoordIntPair(cx, cz));
	}

	@Override
	public void recalculateBlockLighting(World world, int x, int y, int z) {
		net.minecraft.server.v1_7_R2.World w = ((CraftWorld) world).getHandle();
		w.t(x, y, z);
	}
}
